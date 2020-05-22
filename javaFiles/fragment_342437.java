private int selectedBackgroundId = -1;

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.background1:
            mainLayout.setBackgroundResource(R.drawable.redpinkgradientbackground);
            if (selectedBackgroundId == R.id.background1){
                Toast.makeText(getApplicationContext(), "Background already set", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Background set", Toast.LENGTH_SHORT).show();
            }
            selectedBackgroundId = R.id.background1;
            return true;
        case R.id.background2:
            mainLayout.setBackgroundResource(R.drawable.redgradientbackground);
            if (selectedBackgroundId == R.id.background2){
                Toast.makeText(getApplicationContext(), "Background already set", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Background set", Toast.LENGTH_SHORT).show();
            }
            selectedBackgroundId = R.id.background2;
            return true;
        case R.id.background3:
            mainLayout.setBackgroundResource(R.drawable.greengradientbackground);
                if (selectedBackgroundId == R.id.background3){
                    Toast.makeText(getApplicationContext(), "Background already set", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Background set", Toast.LENGTH_SHORT).show();
                }
            selectedBackgroundId = R.id.background3;
            return true;
        case R.id.background4:
            mainLayout.setBackgroundResource(R.drawable.blackgreygradientbackground);
            if (selectedBackgroundId == R.id.background4){
                Toast.makeText(getApplicationContext(), "Background already set", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Background set", Toast.LENGTH_SHORT).show();
            }
            selectedBackgroundId = R.id.background4;
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}