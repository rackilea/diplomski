for (int i=0; i<args.length; i++)
{
   String param = args[i];
   if (!map.containsValue(param))
      logger.error("Unknown parameter:  " + param);
   .. handle argument
}