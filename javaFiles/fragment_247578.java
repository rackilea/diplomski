@Override
public void onClick(SlideButton button, boolean active) {

    if(button.getId() == R.id.btnUp) {
        if(active){
            Toast.makeText(this, "Active Up", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Deactivate Up", Toast.LENGTH_SHORT).show();
        }
    } else if(button.getId() == R.id.btnDown) {
        if(active){
            Toast.makeText(this, "Active Down", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Deactivate Down", Toast.LENGTH_SHORT).show();
        }
    }
}