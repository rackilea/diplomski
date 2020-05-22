public class MyActivity extends Activity {
....
streamListView.setAdapter(this.streamAdapter);
     this.streamListView.setOnItemClickListener(new OnItemClickListener() {
         @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
>>>>>       Intent intent = new Intent(MyActivity.this, MessageDetailActivity.class);
                startActivity(intent);
            }
     });
...
}