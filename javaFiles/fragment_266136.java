function main()
  print(package.path);

  local chatterTools = require("world.NOKORIWARE.lua.chatterTools");
  chatterTools:test();
end