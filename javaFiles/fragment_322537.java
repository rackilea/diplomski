while (c.moveToNext())
    Log.i("Name",c.getString(nameIndex));
    Log.i("Age",Integer.toString(c.getInt(ageIndex)));
    Log.i("id",Integer.toString(c.getInt(idIndex)));
    Log.i("house",c.getString(houseIndex));
    Log.i("street",c.getString(streetIndex));
}