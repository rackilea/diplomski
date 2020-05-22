Mail.defaults do
  delivery_method :smtp, { :address => "smtp.me.com",
                           :port => 587,
                           :domain => 'your.host.name',
                           :user_name => '<username>', 
                           :password => '<password>',
                           :authentication => 'plain',
                           :enable_starttls_auto => true }
end