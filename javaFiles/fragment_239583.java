sassGemDir = 'D:/compass-gems/gems/sass-3.2.13/lib'
compassGemDir = 'D:/compass-gems/gems/compass-0.12.2/lib'
chunkyPngGemDir = 'D:/compass-gems/gems/chunky_png-1.2.9/lib'
fssmGemDir = 'D:/compass-gems/gems/fssm-0.2.10/lib'
$LOAD_PATH.insert(0,sassGemDir,remoteSassGemDir,compassGemDir,chunkyPngGemDir,fssmGemDir)

require 'rubygems'
require 'sass/plugin'
require 'sass/engine'
source = '...the scss code....'
engine = Sass::Engine.new(source,{ :syntax => :scss,:compass => {:css_dir => '/styles',:js_dir => '/scripts',images_dir => '/images'} })
result = engine.render