label {
  display: inline-block;
  cursor: pointer;
  background: orange;
  padding: 5px;
  margin: 30px;
}

.onoffswitch-inner::after {
  content: "DISAPPROVED";
}
.onoffswitch-inner::before {
  content: "APPROVED";
  display: none;
}

#onoff:checked ~ .switch-status .onoffswitch-inner::after {
  display: none;
}
#onoff:checked ~ .switch-status .onoffswitch-inner::before {
  display: inline-block;
}