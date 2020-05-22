require 'serverspec'

# Required by serverspec
set :backend, :exec

describe file('/usr/lib/jvm/java-8-oracle-amd64/release'), :if => os[:family] == "ubuntu" do
  it { should contain 'JAVA_VERSION="1.8.0_31"' }
end

describe file('/usr/lib/jvm/java/release'), :if => os[:family] == "redhat" do
  it { should contain 'JAVA_VERSION="1.8.0_31"' }
end