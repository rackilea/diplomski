(ns clj.core
 (:import
  (com.ibm.watson.developer_cloud.conversation.v1 ConversationService)
  (com.ibm.watson.developer_cloud.conversation.v1.model MessageRequest)
  (com.ibm.watson.developer_cloud.conversation.v1.model MessageResponse)))

(let [username "foo"
     password "bar"
     input "hello"
     context {}
     workspaceId "ibm-watson-id"
     service (ConversationService. "2017-08-26")
     userPass (.setUsernameAndPassword service username password)

     ;just wanna make it work
     msgReq (MessageRequest$Builder.)
     inputText (.inputText msgReq input)
     content (.context inputText context)
     newMessage (.build content)
     response (.execute (.message service workspaceId newMessage))]
   (println  "Watson Response: " response))