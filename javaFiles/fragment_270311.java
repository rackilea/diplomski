public void phoneCall(String number)
{
            String phoneCallUri = "tel:"+number;
            Intent phoneCallIntent =new Intent(Intent.ACTION_CALL);
            phoneCallIntent.setData(Uri.parse(phoneCallUri));
            startActivity(phoneCallIntent);
}