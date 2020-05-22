$("form").live("submit", submitListener);

function submitListener(e) {
   // your handling stuff goes here
   e.preventDefault();
}