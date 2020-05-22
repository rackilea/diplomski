if(flag.equals(landlord)){
Intent intent = new Intent(this,Landlord.class);
 startActivity(intent);
}
else{
 Intent intent = new Intent(this,Tenant.class);
 startActivity(intent);
 }