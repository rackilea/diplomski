Map<String, Class<? extends AbstractRestCommand>> map =
                    new HashMap<String, Class<? extends AbstractRestCommand>>();
map.put("PUT", PutCommand.class);
map.put("DELETE", DeleteCommand.class);
...
Class<? extends AbstractRestCommand> cmdType = map.get(cmdName);
if(cmdType != null)
{
    AbstractRestCommand command = cmdType.newInstance();
    if(command != null)
        command.execute();
}