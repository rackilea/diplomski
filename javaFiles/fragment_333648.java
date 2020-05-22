DatabaseReference refNew = FirebaseDatabase.getInstance().getReference().child("userTable").child(i);

// where i is the variable which you have to keep count of your users

ref.child("Age").setValue(age);
ref.child("Company").setValue(company); // and so on

// age, company are variable with values you want to store