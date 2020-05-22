remote_file "#{base_dir}/webapps/prodservice.war" do
  source "http://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=log4j&a=log4j&v=LATEST"
  owner "onamer"
  group "gname"
  notifies :restart, "service[#{service_name}]"
end