ColorPickerView colorPickerView = (ColorPickerView) findViewById(R.id.color_picker_view);

        colorPickerView.addOnColorChangedListener(new OnColorChangedListener() {

            @Override public void onColorChanged(int selectedColor) {

                // Handle on color change

                Log.d("ColorPicker", "onColorChanged: 0x" + Integer.toHexString(selectedColor));

            }

        });

        colorPickerView.addOnColorSelectedListener(new OnColorSelectedListener() {

            @Override

        public void onColorSelected(int selectedColor) {

            Toast.makeText(

                    SampleActivity2.this,

                    "selectedColor: " + Integer.toHexString(selectedColor).toUpperCase(),

                    Toast.LENGTH_SHORT).show();

        }

    });