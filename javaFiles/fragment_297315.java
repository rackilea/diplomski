{
  "commands": {
    "facepalm": {
      "blamenill": {
        "usage": "/blamenill", 
        "description": "Makes you blame Nill.", 
        "permission": "compmeme.blamenill"
      }, 
      "description": "Makes you facepalm.", 
      "ragequit": {
        "usage": "/ragequit", 
        "description": "Makes you ragequit.", 
        "permission": "compmeme.ragequit"
      }, 
      "permission": "compmeme.facepalm", 
      "odns": {
        "usage": "/odns", 
        "description": "One does not simply...", 
        "permission": "compmeme.odns"
      }, 
      "rage": {
        "usage": "/rage [activate/deactivate]", 
        "permission": "compmeme.rage", 
        "description": "Activate or deactivate rage mode.", 
        "aliases": "ragemode"
      }, 
      "lol": {
        "usage": "/lol", 
        "description": "Makes you laugh out loud.", 
        "permission": "compmeme.lol"
      }, 
      "iliketrains": {
        "usage": "/iliketrains", 
        "permission": "compmeme.lol", 
        "description": "Show your support for trains.", 
        "aliases": "trains"
      }, 
      "usage": "/facepalm", 
      "compmeme": {
        "usage": "/compmeme <info/enable/disable>", 
        "permission": "compmeme.compmeme", 
        "description": "CompMeme information command.", 
        "aliases": "ragemode"
      }
    }, 
    "rofl": {
      "usage": "/rofl", 
      "description": "Makes you roll on the floor laughing.", 
      "permission": "compmeme.rofl"
    }
  }, 
  "permissions": {
    "compmeme.*": {
      "default": "op", 
      "description": "Ops get ALL the commands!", 
      "children": {
        "compmeme.odns": true, 
        "compmeme.facepalm": true, 
        "compmeme.iliketrains": true, 
        "compmeme.blamenill": true, 
        "compmeme.rofl": true, 
        "compmeme.ragequit": true, 
        "compmeme.rage": true, 
        "compmeme.compmeme": true, 
        "compmeme.disable": true, 
        "compmeme.lol": true, 
        "compmeme.enable": true
      }
    }
  }
}