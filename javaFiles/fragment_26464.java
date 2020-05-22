builder.setBigContentTitle(bigContentTitle)
       .bigPicture(imageBitmap);

if (summaryText.length() > 0){
    builder.setSummaryText(summaryText); // only apply if parameter length > 0
}

return (builder.build());