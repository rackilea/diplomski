(ns jdatepickertest.core)

(import
   '(java.util Enumeration Locale Properties ResourceBundle)
   '(javax.swing JFrame)
   '(org.jdatepicker JDatePicker JDatePanel)
   '(org.jdatepicker.i18n)
   '(org.jdatepicker.impl JDatePanelImpl JDatePickerImpl UtilDateModel UtilCalendarModel)
)

(Locale. "pt")

(defn now [] (new java.util.Date))

(defn CreateAWindow[]
  (doto(JFrame. "Hello Frame")
  (.setSize 400 200)
  (.setVisible true))
)

(defn CreateUtilDateModel[yyyy m d]
  (doto (UtilDateModel.) (.setDate yyyy m d) (.setSelected true)))

(defn CreateJDatePanelImpl[model properties](JDatePanelImpl. model properties))

(defn CreateJDatePickerImpl[datePanel properties](JDatePickerImpl. datePanel properties))

(defn SetModelDefaultDate[model yyyy m d](. model setDate yyyy m d))

(defn GetDefaultStrings[]
  (doto(Properties.)
        (.put "text.today", "Today")
        (.put "text.nextMonth", "Next month")
        (.put "text.previousMonth", "Previous month")
        (.put "text.nextYear", "Next year")
        (.put "text.previousYear", "Previous year")
        (.put "text.clear", "Clear")
  )
)

(defn PutitAllTogether[]
  (let [window   (CreateAWindow)
        model    (CreateUtilDateModel 2014 12 5)
        prop     (GetDefaultStrings)
        jdpanel  (CreateJDatePanelImpl model prop)
        jdpicker (CreateJDatePickerImpl jdpanel nil)]

        (.setContentPane window jdpanel)
  )
)

;(CreateUtilDateModel 2014 12 5)

(defn PutAlittleTogether[]
  (let[model (CreateUtilDateModel 2014 12 5)]))

;(PutAlittleTogether)

(PutitAllTogether)