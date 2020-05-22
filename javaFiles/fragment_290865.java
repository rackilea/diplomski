seek_bar1.setOnSeekBarChangeListener(

        new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text_view.setText(String.valueOf(progress) + "%");

                exam_grade = progress;
                total = exam_grade + homework;
                total_view.setText(String.valueOf(total));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }
);

seek_bar2.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener(){


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text_view2.setText(String.valueOf(progress)+"%");
                homework = progress;
                total = exam_grade + homework;
                total_view.setText(String.valueOf(total));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        }
);