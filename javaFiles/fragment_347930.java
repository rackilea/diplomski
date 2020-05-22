// This file overrides the built-in Node.js (default) runner
// For more information see http://docs.c9.io:8080/#!/api/run-method-run
{
  "cmd": [
    "bash",
    "--login",
    "-c",
    "nvm use default > /dev/null; node ${debug?--nocrankshaft --nolazy --nodead_code_elimination --debug-brk=15454} '$file' $args"
  ],
  "selector": "source.js",
  "info": "Your code is running at \\033[01;34m$url\\033[00m.\n\\033[01;31mImportant:\\033[00m use \\033[01;32mprocess.env.PORT\\033[00m as the port and \\033[01;32mprocess.env.IP\\033[00m as the host in your scripts!\n"
}