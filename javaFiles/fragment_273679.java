case R.id.rlCompanyProfile:
Base item = null; // item object is null here
Company company = (Company) item ;// here you are passing null item object of your Company class
Intent intent = new Intent(this, AddCompanyActivity.class);
intent.putExtra("company", item);
intent.putExtra("edit", "editFrag");
startActivity(intent);
break;