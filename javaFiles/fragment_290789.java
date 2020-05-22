import java.lang.reflect.Field;
/* ... */

for (int i = 1; i < 16; i++) {
    int id = R.id.class.getField("s" + i).getInt(0);
    tv[i] = (TextView)findViewById(id);
    tv[i].setTypeface(face);
    tv[i].setClickable(true);
    tv[i].setOnClickListener(clickListener);
}