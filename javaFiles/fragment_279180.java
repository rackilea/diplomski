plugins {
    id 'net.ltgt.apt-idea' version '0.13'
}

apply plugin: 'idea'
apply plugin: "net.ltgt.apt"

dependencies {
    apt "org.mapstruct:mapstruct-processor:${mapstruct_version}"
    apt "org.hibernate:hibernate-jpamodelgen:${hibernate_version}"
}