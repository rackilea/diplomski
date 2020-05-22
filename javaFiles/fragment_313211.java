ArrayList<ListModel> arrayList = new ArrayList<>();

for (int i = 0; i <10; i++) {

    ListModel model = new ListModel();

    model.setName("Name " + i);
    model.setAddress("Address " + i);
    model.setImage("Image " + i);

    arrayList.add(model);
}

// YOU CAN USE THIS LIST IN YOUR ADAPTER JUST PASS YOUR ARRAYLIST INTO ADAPTER
CustomCurationAdaptor adapter = new CustomCurationAdaptor(this, arrayList);