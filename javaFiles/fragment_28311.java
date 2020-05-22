boolean isServiceRunning = isServiceRunning(MyService.class.getName(), this.getApplicationContext());

if (!isServiceRunning)
{
    Intent startMyServiceIntent = new Intent(this.getApplicationContext(), MyService.class);

    startService(startMyServiceIntent);
}