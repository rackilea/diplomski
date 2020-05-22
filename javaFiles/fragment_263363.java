L: list of objects that can potentially collide.
t: time

for each frame in t {
    for each object obj in L {
        P: list of objects without obj
        for each object otherObj in P {
             does obj collide with otherObj
        }
    }
}