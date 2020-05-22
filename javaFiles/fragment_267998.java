// declare "colorString2"
final String[] colorString2 = new String[36];
// initialize with values
colorString2[0] = "yellow";
colorString2[1] = "red";
colorString2[2] = "green";
colorString2[3] = "black";
colorString2[4] = "white";
colorString2[5] = "purple";
colorString2[6] = "blue";
colorString2[7] = "brown";
colorString2[8] = "orange";
colorString2[9] = "weyoll";
colorString2[10] = "loyelw";
colorString2[11] = "oelwyl";
colorString2[12] = "erd";
colorString2[13] = "der";
colorString2[14] = "edr";
colorString2[15] = "enrge";
colorString2[16] = "regne";
colorString2[17] = "nerge";
colorString2[18] = "lcbka";
colorString2[19] = "alkcb";
colorString2[20] = "cbakl";
colorString2[21] = "ihewt";
colorString2[22] = "thewi";
colorString2[23] = "ewthi";
colorString2[24] = "relppu";
colorString2[25] = "ulrpep";
colorString2[26] = "leprpu";
colorString2[27] = "ebul";
colorString2[28] = "lbeu";
colorString2[29] = "ulbe";
colorString2[30] = "rbwno";
colorString2[31] = "wobnr";
colorString2[32] = "onwrb";
colorString2[33] = "agonre";
colorString2[34] = "negrao";
colorString2[35] = "greaon";

// select first color string to be used for as word
word.setText(colorString2[decider]);
// select first visual color to be used for word
int[] androidColors =getResources().getIntArray(R.array.androidcolors);
int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
word.setTextColor(randomAndroidColor);

// create click listener for yellow button
yellowButton.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View v) {
            // on click, check if word color is matching
            // this buttons color and increase score
            if (word.getText().equals(colorString2[0])) {
                score++;
            }
            if (word.getText().equals(colorString2[9])) {
                score++;
            }
            if (word.getText().equals(colorString2[10])) {
                score++;
            }
            if (word.getText().equals(colorString2[11])) {
                score++;
            }
            // select new color string with difficulty level
            // depending on score
            Random colStr = new Random();
            if (score<=9) {
                decider = colStr.nextInt(9);
            }
            if (score>9) {
                decider = colStr.nextInt(27)+9;
            }
            word.setText(colorString2[decider]);
            // set new visual color
            int[] androidColors = getResources().getIntArray(R.array.androidcolors);
            int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
            word.setTextColor(randomAndroidColor);
        }
    });

/* same for other colored buttons */