G.metaClass.run = { println 'Groovy!!!' }

g2 = new G()
g.run()
g1.run()
g2.run()