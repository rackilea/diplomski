Intent secondIntent=new Intent(CustomArrayList.this,SecondArrayList.class);
           Bundle bundle=new Bundle();
           //inorder to send custom arraylist from one activity to another activity we need to use either parcelable or serializable.here am using parcelable for beter performance..
            bundle.putParcelableArrayList("List",datas);
            secondIntent.putExtra("Bundle",bundle);
            startActivity(secondIntent);