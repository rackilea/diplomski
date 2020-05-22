private ArrayList<String> fruits_list;
    private ArrayAdapter<String> arrayAdapter;
    ...
    public void initialise(Context context) {
        fruits_list = new ArrayList<>(Arrays.asList(fruits));
        arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, fruits_list);
        lv.setAdapter(arrayAdapter);
    }
    ....
    public void getInput(
        mass = userInput.getText().toString();
        fruits_list.add(mass);
        arrayAdapter.notifyDataSetChanged();
    }