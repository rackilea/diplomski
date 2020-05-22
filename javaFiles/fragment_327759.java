class MainActivity extends Activity{
...
  @Override
   public void onSongSelected(String title, String content){ 
     bottomSheet.titleView.setText(title);
     bottomSheet.contentView.setText(content);
   }
}