invia.Click += delegate
            {
                string user = utenteInserito.Text;
                string password = passwordInserito.Text;
                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://192.168.1.11:57279/api/");
                var utente = new Utente
                {
                    user = user,
                    password = password
                };
                var postTask = client.PostAsJsonAsync<Utente>("utente", utente);
                postTask.Wait();
            };