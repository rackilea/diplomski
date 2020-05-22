Grape.metaClass.static.grab = {String endorsed ->
    throw new SecurityException("Oh no you didn't! Grabbing is forbidden.")
}

Grape.metaClass.static.grab = {Map dependency ->
    throw new SecurityException("Oh no you didn't! Grabbing is forbidden.")
}

Grape.metaClass.static.grab = {Map args, Map dependency ->
    throw new SecurityException("Oh no you didn't! Grabbing is forbidden.")
}