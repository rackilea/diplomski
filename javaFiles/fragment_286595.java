@Override
public void onDataChange(DataSnapshot snapshot){
    // Add the new data to your data set ex. myData.add(newData)
    // ...

    // After adding to the data set,
    // update the data using a custom function you define in your Adapter's class
    myAdapter.updateData(myData);
}