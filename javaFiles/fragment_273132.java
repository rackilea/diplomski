[
    {
        "locations": {
            "description": "You look around the room and see you are in an empty room with 2 doors to the left and to the right. Knowing not how you got there, you decide to figure out how to escape and get back to your normal life.",
            "name": "start",
            "objects": [],
            "directions": [{
                    "direction": "right",
                    "location": "empty room1"
                }, {
                    "direction": "left",
                    "location": "dungeon"
                }]
        }
    },
    {
        "locations": {
            "description": "Inside this room it looks like some sort of dungeon with a cage in the middle and blood lining the wall and floor.",
            "name": "dungeon",
            "objects": ["map", "torch"],
            "directions": [{
                    "direction": "up",
                    "location": "hallway2"
                }, {
                    "direction": "down",
                    "location": "hallway1"
                }, {
                    "direction": "right",
                    "location": "start"
                }]
        }
    }
]