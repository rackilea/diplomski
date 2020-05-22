int spinner1SelectionPos;
int spinner2SelectionPos;
public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
    switch (parent.getId()) {
        case R.id.spinner1:
            spinner1SelectionPos = pos;
            break;
        case R.id.spinner2:
            spinner2SelectionPos = pos;
            break;
    }

    int fcityKey = getMapKey(from, title.get(spinner1SelectionPos));
    int tcityKey = getMapKey(to, title2.get(spinner2SelectionPos));

    String message = title.get(spinner1SelectionPos) + " " + fcityKey
            + " " + title2.get(spinner2SelectionPos) + " " + tcityKey;

    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
}

//for getting key from a map using value
private int getMapKey(Map<Integer, City> map, String value) {
    for (Map.Entry<Integer, City> item : map.entrySet()) {
        if (item.getValue().getName().equals(value)) return item.getKey();
    }

    return -1;
}