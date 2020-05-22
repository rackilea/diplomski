Cursor res2 = dal.selectMotivosWhereId(position);
res2.moveToFirst();
StringBuilder sb = new StringBuilder();
while (!res2.isAfterLast()) 
{
    sb.append(res2.getString(res2.getColumnIndex(DBContract.Motivo_sintomas.COL_Motivo));
    res2.moveToNext();
}
 Motivo.setText(sb.toString());