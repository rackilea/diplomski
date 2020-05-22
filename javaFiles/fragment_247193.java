if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()))
{
    String componentName = context.getPackageName() + "/.AppEntry";
    Intent i = new Intent( Intent.ACTION_MAIN );
    i.setComponent(ComponentName.unflattenFromString( componentName ));
    i.addCategory( Intent.CATEGORY_LAUNCHER );
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity( i );
}