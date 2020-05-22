// activity a
Intent intent = new Intent(getApplicationContext(),YourActivity.class);
Bundle bundle = new Bundle();
bundle.putParcelable("test", arrayList);
intent.putExtras(bundle);
startActivity(intent);