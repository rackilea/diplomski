Film item = getItem(position);
boolean needsDivider = (position == 0 || getItem(position - 1).filmCategory != film.filmCategory);
if (needsDivider)
{
    dividerView.setVisibility(View.VISIBLE);
    dividerView.setText(getFilmCategoryName(film.filmCategory));
}
else
    dividerView.setVisibility(View.GONE);