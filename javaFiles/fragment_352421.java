@Override
public void onClick(View v) {

    switch (v.getId()) {

        case R.id.minioncentreid:
            goldCount += 1.0;
            textTotal = goldCount + " Gold";
            textGoldCount.setText(textTotal);
            break;
    }