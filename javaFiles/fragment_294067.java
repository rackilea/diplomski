package main

import (
    "fmt"
)

type ConnectionData string
type SessionData string
type User string

type WebEntry func(connectionData ConnectionData, sessionData SessionData) string
type WebEntryUserLoggedIn func( user User ) string

func main() {
    var webentries []WebEntry
    webentries = append( webentries, userLoggedInWebEntry(SavePasswordWebEntry) )

    // Test the invocation
    fmt.Println( webentries[0]("ConnectionData", "SessionData") )
}


func userLoggedInWebEntry( webEntry WebEntryUserLoggedIn ) WebEntry {

    return func(connectionData ConnectionData, sessionData SessionData) string {
        // // THIS IS THE LOGIC I DO NOT WANT TO DUPLICATE, HENCE ITS USING CLASS INHERITANCE
        var user User = "John"
        return webEntry( user )
    } 

}


func SavePasswordWebEntry( user User ) string {
    return fmt.Sprintf("user is %s", user )
}