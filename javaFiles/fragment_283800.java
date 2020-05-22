public void go(View view)
{
    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
    intent.putExtra(ResultsActivity.HungerValueTag, hungerValue);
    intent.putExtra(ResultsActivity.CuisineValueTag, cuisineValue);
    intent.putExtra(ResultsActivity.PrepValueTag, prepValue);
    intent.putExtra(ResultsActivity.CourseValueTag, CourseValue);

    startActivity(intent);
}