ArrayList<TextView> array = new ArrayList<>();
array.add(setTime1);
array.add(setTime2);
//Add all your setTime files

StringBuilder sb = new StringBuilder();

for (int i = 0; i < howmanytimes-1; i++) {
     sb.append(array.get(i).getText().toString() + ", ");
}

sb.append(array.get(howmanytimes-1).getText().toString();

String allHours = sb.toString();