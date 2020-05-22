switch(item.getItemId()){
    case R.id.another_intent:
        Intent intent = new Intent(IntentExamples.this, IntentExamples.class);
        startActivity(intent);
    case android.R.id.home:
        this.finish(); break;
    default:
        return false;
}