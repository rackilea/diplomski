Bundle params = new Bundle();
params.putLong(Parameter.Builtin.PERIOD.name, 10L); // Run every 10 seconds

Intent probeIntent = new Intent(getContext(), probeClass);
probeIntent.setAction(Probe.ACTION_REQUEST);
probeIntent.putExtra(Probe.CALLBACK_KEY, callback);
probeIntent.putExtra(Probe.REQUESTS_KEY, params);
getContext().startService(probeIntent);