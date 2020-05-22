const forms = document.querySelectorAll('.store-form');
forms.forEach(form => {
   form.addEventListener('submit', event => {

   // Stop the normal form submit triggered by the submit button
   event.preventDefault();

   const formInputs = form.getElementsByTagName("input");
   let formData = new FormData();
   for (let input of formInputs) {
       formData.append(input.name, input.value);
   }

   fetch(form.action,
   {
        method: form.method,
        body: formData
   })
   .then(response => response.json())
   .then(data => console.log(data))
   .catch(error => console.log(error.message))
   .finally(() => console.log("Done"));
});