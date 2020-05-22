(clear)
(deftemplate Data (declare (from-class Data)))
(defrule matchab
   (declare (no-loop TRUE))
   ?data <- (Data {a > b} (b ?b))
=>
   (printout t (fact-slot-value ?data a) " and " ?b crlf)  
   (modify ?data (res agtb))
)