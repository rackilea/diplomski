// turn up the logging
db.setProfilingLevel(2)

// ... run some commands

// find all profiler documents, most recent first
db.system.profile.find().sort( { ts : -1 } )

// turn down the logging
db.setProfilingLevel(0)