if(POS >= Integer.parseInt(getString(R.string.lastaricle))){
     Toast.makeText(SubActivity.this, R.string.last, Toast.LENGTH_SHORT).show();
} else {
     POS += 1;
     fillDetails(POS);
}