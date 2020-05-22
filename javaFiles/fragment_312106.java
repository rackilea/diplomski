package com.example

class HelloWorld {

    def static void main(String[] args) {
        val instance = new HelloWorld
        println(instance.generateC)
    }

    def String generateC() '''
        #include<stdio.h>

        main()
            intf("Hello World");
        }
    '''

}