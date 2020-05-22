class Duck {
    quack() { println "I am a Duck" }
}

class Frog {
    quack() { println "I am a Frog" }
}

quackers = [ new Duck(), new Frog() ]
for (q in quackers) {
    q.quack()
}